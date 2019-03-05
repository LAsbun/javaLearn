package designmodel.command;

/**
 * @author
 */
abstract class AbstractionCommand implements Command {

  protected Receiver receiver;

  public AbstractionCommand(Receiver receiver) {
    this.receiver = receiver;
  }

}
