package project.util;

import java.util.ArrayList;

public class Menu {

  private String title;
  private ArrayList<ActionListener> listeners = new ArrayList<>();
  private BreadcrumbPrompt prompt;
  private String string;

  public Menu(BreadcrumbPrompt prompt) {
    this.prompt = prompt;
  }

  public Menu(String string, ActionListener listener) {
    this.addActionListener(listener);
  }


  public Menu(String string) {
    this.string = string;
  }

  public void addActionListener(ActionListener listener) {
    listeners.add(listener);
  }

  public void removeActionListener(ActionListener listener) {
    listeners.remove(listener);
  }

  public String getTitle() {
    return title;
  }

  public void execute(BreadcrumbPrompt prompt) {
    for (int i = 0; i < listeners.size(); i++) {
      ActionListener listener = listeners.get(i);
      listener.service(prompt);

    }
  }
}
