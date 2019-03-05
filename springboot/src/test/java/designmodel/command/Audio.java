package designmodel.command;

import lombok.Data;

/**
 * @author
 */
@Data
public class Audio {

  private Command startCommand;
  private Command stopCommand;
  private Command fastForwardCommand;


  public void start(){
    startCommand.execute();
  }

  public void stop(){
    stopCommand.execute();
  }

  public void fastForward(){
    fastForwardCommand.execute();
  }

}
