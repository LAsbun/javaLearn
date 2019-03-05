package designmodel.command;

/**
 * @author
 */
public class StartCommand extends AbstractionCommand {

  public StartCommand(Receiver receiver) {
    super(receiver);
  }

  @Override
  public void execute() {

    this.receiver.start();

  }
}
