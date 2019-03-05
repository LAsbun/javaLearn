package designmodel.command;

/**
 * @author
 */
public class FastForwardCommand extends AbstractionCommand {


  public FastForwardCommand(Receiver receiver) {
    super(receiver);
  }

  @Override
  public void execute() {
    this.receiver.fastForward();
  }
}
