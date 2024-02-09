package duke.commands;

import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.storage.TaskList;
import duke.tasks.Task;
import duke.ui.Ui;

/**
 * FindCommand class represents a command to search for tasks containing a specific keyword.
 * It extends the Command class and provides methods to execute the command.
 */
public class FindCommand extends Command {
    private String searchTerm;

    /**
     * Constructs a FindCommand object with the specified search term.
     *
     * @param searchTerm The search term to find in tasks.
     */
    public FindCommand(String searchTerm) {
        super();
        this.searchTerm = searchTerm.toLowerCase();
    }

    /**
     * Executes the find command by searching for tasks containing the search term.
     * Displays the matching tasks, if any, or a message if no matches are found.
     *
     * @param taskList The list of tasks to search.
     * @param ui       The user interface (not used in this command).
     * @param storage  The storage handler (not used in this command).
     * @throws DukeException If an error occurs during command execution.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        TaskList searchResults = new TaskList();
        for (int i = 0; i < taskList.size(); i++) {
            Task currTask = taskList.get(i);
            if (currTask.match(searchTerm)) {
                searchResults.add(currTask);
            }
        }

        if (searchResults.size() != 0) {
            System.out.println(searchResults);
        } else {
            System.out.println("Sorry, there are no matching entries.");
        }
    }
}
