package bitcamp.myapp2.handler;

import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class HeadListener implements ActionListener {

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("============================= head===========");
  }

}
