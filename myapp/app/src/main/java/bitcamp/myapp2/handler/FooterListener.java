package bitcamp.myapp2.handler;

import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class FooterListener implements ActionListener {

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("-----------Copyright \u00a9 by nc7 ---------------");
  }

}
