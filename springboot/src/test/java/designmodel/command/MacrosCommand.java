package designmodel.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 宏命令
 *
 * @author
 */
public class MacrosCommand implements Command {

  public List<Command> commandList = new ArrayList<>();

  @Override
  public void execute() {

    commandList.forEach(Command::execute);
  }


  public void addCommand(Command command) {

    commandList.add(command);
  }
}
