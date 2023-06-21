package bitcamp.util;

public class Menu {
  private String title;
  private ArrayList listners = new ArrayList();

  public Menu(String title) {
    this.title = title;
  }

  public Menu(String title, ActionListener listener) {
    this(title);
    this.addActionListener(listener);
  }


  public void addActionListener(ActionListener listner) {
    listners.add(listner);
  }

  public void removeActionListener(ActionListener listner) {
    listners.remove(listner);
  }

  public String getTitle() {
    return title;
  }

  public void execute(BreadcrumbPrompt prompt) {
    for (int i = 0; i < listners.size(); i++) {
      ActionListener listener = (ActionListener) listners.get(i);
      listener.service(prompt);
    }
  }
}
