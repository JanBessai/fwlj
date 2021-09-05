package parser;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

import org.antlr.v4.runtime.*;

import ast.*;
import op.*;

public class JParser {
  public String codeFromPath(Path path) throws IOException{
    String code=Files.readString(path,StandardCharsets.US_ASCII);
    return code.replace("\r","");
    }
  public Program program(Path fileName,String s){
    var l=new generated.JLexer(CharStreams.fromString(s));
    var t = new CommonTokenStream(l);
    var p=new generated.JParser(t);
    StringBuilder errorsTB=new StringBuilder();
    StringBuilder errorsPB=new StringBuilder();
    l.removeErrorListener(ConsoleErrorListener.INSTANCE);
    l.addErrorListener(new FailConsole(fileName,errorsTB));
    p.removeErrorListener(ConsoleErrorListener.INSTANCE);
    p.addErrorListener(new FailConsole(fileName,errorsPB));
    var v=new ParserVisitor();
    Program res=v.visitProg(p.prog());
    var errorsT= errorsTB.toString();
    var errorsP= errorsPB.toString();
    var hasErr=!errorsT.isEmpty() || !errorsP.isEmpty();
    if (hasErr){ throw new ParserFailed(errorsT+"\n"+errorsP); }
    return new ReplaceFreshXs().fixProgram(res); 
    }
  }  
class FailConsole extends ConsoleErrorListener{
  public final StringBuilder sb;
  public final Path fileName;
  public FailConsole(Path fileName,StringBuilder sb){
    this.fileName=fileName;
    this.sb=sb;
    }
  @Override public void syntaxError(Recognizer<?, ?> r,Object o,int line,int charPos,String msg,RecognitionException e){
    sb.append("Parser error in \n"+fileName.toUri()+"\n line="+line+"\n pos="+charPos+"\n"+ msg);
    }
  }