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

package de.gishmo.gwt.example.nalu.simpleapplication.client;

import com.github.mvp4g.nalu.client.application.IsContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.service.FakedMailServer;

/**
 * A application context of the Mvp4g2MailApplication
 */
public class NaluSimpleApplicationContext
  implements IsContext {

  private String version;

  private FakedMailServer fakedMailServer;

  public NaluSimpleApplicationContext() {
    this.version = "1.0.0";
    this.fakedMailServer = new FakedMailServer();
  }

  public String getVersion() {
    return version;
  }

  public FakedMailServer getFakedMailServer() {
    return fakedMailServer;
  }
}
