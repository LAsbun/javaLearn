package designmodel.command;

import org.junit.Test;

/**
 * @author
 */
public class test {


  @Test
  public void test1() {

    Receiver receiver = new Receiver();

    MacrosCommand macrosCommand = new MacrosCommand();
    macrosCommand.addCommand(new StartCommand(receiver));
    macrosCommand.addCommand(new FastForwardCommand(receiver));
    macrosCommand.addCommand(new StopCommandImpl(receiver));
    macrosCommand.addCommand(new StartCommand(receiver));
    macrosCommand.addCommand(new StopCommandImpl(receiver));

    macrosCommand.execute();
  }

  @Test
  public void test0() {

    Receiver receiver = new Receiver();

    Audio audio = new Audio();
    audio.setFastForwardCommand(new FastForwardCommand(receiver));
    audio.setStartCommand(new StartCommand(receiver));
    audio.setStopCommand(new StopCommandImpl(receiver));

    audio.start();
    audio.fastForward();
    audio.stop();
    audio.start();
    audio.stop();

  }
}
