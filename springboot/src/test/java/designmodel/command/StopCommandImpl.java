package designmodel.command;

/**
 * @author
 */
public class StopCommandImpl extends AbstractionCommand {

  public StopCommandImpl(Receiver receiver) {
    super(receiver);
  }

  @Override
  public void execute() {
    this.receiver.stop();
  }
}
