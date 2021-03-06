/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.shell;

import com.github.mvp4g.nalu.client.component.AbstractShell;
import com.github.mvp4g.nalu.plugin.gwt.client.annotation.Selector;
import com.github.mvp4g.nalu.plugin.gwt.client.selector.IsSelectorProvider;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.resources.ApplicationCss;
import de.gishmo.gwt.example.nalu.simpleapplication.client.resources.ApplicationStyleFactory;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
public class Shell
  extends AbstractShell<NaluSimpleApplicationContext> {

  @Selector("header")
  SimpleLayoutPanel headerWidget;
  @Selector("footer")
  ResizeLayoutPanel footerWidget;
  @Selector("navigation")
  SimpleLayoutPanel navigationWidget;
  @Selector("content")
  SimpleLayoutPanel contentWidget;
  private ResizeLayoutPanel shell;
  private ApplicationCss    style;

  public Shell() {
    super();
  }

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   * <p>
   * We append the shell to the browser body.
   */
  @Override
  public void attachShell() {
    RootLayoutPanel.get()
                   .add(this.render());
  }

  private Widget render() {
    this.style = ApplicationStyleFactory.get()
                                        .getStyle();

    shell = new ResizeLayoutPanel();
    shell.setSize("100%",
                  "100%");
    //shell.addResizeHandler(event -> forceLayout());

    DockLayoutPanel panel = new DockLayoutPanel(Style.Unit.PX);
    panel.setSize("100%",
                  "100%");
    shell.add(panel);

    this.headerWidget = createNorth();
    panel.addNorth(this.headerWidget,
                   128);

    this.footerWidget = createSouth();
    panel.addSouth(this.footerWidget,
                   42);

    this.navigationWidget = createNavigation();
    panel.addWest(this.navigationWidget,
                  212);

    this.contentWidget = createContent();
    panel.add(this.contentWidget);

    return panel;
  }

  private SimpleLayoutPanel createNorth() {
    SimpleLayoutPanel panel = new SimpleLayoutPanel();
    panel.addStyleName(style.headerPanel());
    panel.getElement()
         .setId("header");
    return panel;
  }

  private ResizeLayoutPanel createSouth() {
    ResizeLayoutPanel footerPanel = new ResizeLayoutPanel();
    footerPanel.getElement()
               .setId("footer");
    return footerPanel;
  }

  private SimpleLayoutPanel createNavigation() {
    SimpleLayoutPanel panel = new SimpleLayoutPanel();
    panel.addStyleName(style.navigationPanel());
    panel.getElement()
         .setId("navigation");
    return panel;
  }

  private SimpleLayoutPanel createContent() {
    SimpleLayoutPanel panel = new SimpleLayoutPanel();
    panel.getElement()
         .setId("content");
    return panel;
  }

//    private void forceLayout() {
//      if (shell.isAttached()) {
//        Widget parent = shell.getParent();
//        if (parent != null) {
//          int parentWidth = parent.getOffsetWidth();
//          footerPanel.setWidth(Integer.toString(parentWidth) + "px");
//        }
//      }
//    }

  @Override
  public void bind() {
    IsSelectorProvider<Shell> provider = new ShellSelectorProviderImpl();
    provider.initialize(this);
  }
}
