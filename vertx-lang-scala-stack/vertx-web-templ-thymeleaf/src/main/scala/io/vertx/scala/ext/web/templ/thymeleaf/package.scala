/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package io.vertx.scala.ext.web.templ

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web.templ.thymeleaf.{ThymeleafTemplateEngine => JThymeleafTemplateEngine}
import io.vertx.core
import org.thymeleaf.templatemode.TemplateMode
import io.vertx.ext.web.common.template.{TemplateEngine => JTemplateEngine}
import io.vertx.ext.web.common.template
import io.vertx.core.{Vertx => JVertx}
package object thymeleaf{


  object ThymeleafTemplateEngine {
    /**
     * Create a template engine using defaults     * @return the engine
     */
  def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine.create(vertx)
  }
  }


}