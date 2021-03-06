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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.content.list;

import com.github.mvp4g.nalu.client.component.AbstractComponentController;
import com.github.mvp4g.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Mail;
import de.gishmo.gwt.example.nalu.simpleapplication.client.event.StatusChangeEvent;

import java.util.List;

@Controller(route = "/",
  selector = "north",
  componentInterface = IListComponent.class,
  component = ListComponent.class)
public class ListController
  extends AbstractComponentController<NaluSimpleApplicationContext, IListComponent, Widget>
  implements IListComponent.Controller {

  public ListController() {
  }

  @Override
  public void start() {
    List<Mail> listOfEmails = this.context.getFakedMailServer()
                                          .getAllMails();
    this.component.edit(listOfEmails);
    this.eventBus.fireEvent(new StatusChangeEvent("Found: " + listOfEmails.size() + " email(s)"));
  }

  @Override
  public void doSelectRow(String id) {
    this.router.route("/mail",
                      id);
  }
}
