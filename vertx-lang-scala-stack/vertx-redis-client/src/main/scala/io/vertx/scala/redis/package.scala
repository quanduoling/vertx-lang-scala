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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.buffer.Buffer
import io.vertx.redis.client.{Command => JCommand}
import io.vertx.redis.client.{Request => JRequest}
package object redis{


  object Command {
    /**
     * Creates a Redis Command from METADATA. The metadata comes from the REDIS command "COMMAND"
     * https://redis.io/commands/command
     *
     * Each top-level result contains six nested results. Each nested result is:
     *
     *     command name
     *     command arity specification
     *     nested Array reply of command flags
     *     position of first key in argument list
     *     position of last key in argument list
     *     step count for locating repeating keys     * @param command command name
     * @param arity arity
     * @param firstKey position of the first key
     * @param lastKey position of the last key
     * @param interval step count for locating repeating keys
     * @param readOnly readOnly flag extracted from the nested Array reply of command flags
     * @param movable movable flag extracted from the nested Array reply of command flags
     * @return a command instance
     */
  def create(command: java.lang.String, arity: java.lang.Integer, firstKey: java.lang.Integer, lastKey: java.lang.Integer, interval: java.lang.Integer, readOnly: java.lang.Boolean, movable: java.lang.Boolean) = {
      io.vertx.redis.client.Command.create(command, arity, firstKey, lastKey, interval, readOnly, movable)
  }
  }



  /**
    * A simple Redis client.

    */

  implicit class RedisScala(val asJava: io.vertx.redis.client.Redis) extends AnyVal {


    /**
     * Like connect from [[io.vertx.redis.client.Redis]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def connectFuture() : scala.concurrent.Future[io.vertx.redis.client.RedisConnection] = {
      val promise = concurrent.Promise[io.vertx.redis.client.RedisConnection]/*io.vertx.redis.client.RedisConnection API*/()
      asJava.connect(new Handler[AsyncResult[io.vertx.redis.client.RedisConnection]] { override def handle(event: AsyncResult[io.vertx.redis.client.RedisConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.redis.client.Redis]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(command: io.vertx.redis.client.Request) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.send(command, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like batch from [[io.vertx.redis.client.Redis]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def batchFuture(commands: scala.collection.mutable.Buffer[io.vertx.redis.client.Request]) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.redis.client.Response]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.redis.client.Response]]/*java.util.List[io.vertx.redis.client.Response] LIST*/()
      asJava.batch(commands.asJava, new Handler[AsyncResult[java.util.List[io.vertx.redis.client.Response]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.redis.client.Response]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }


  }




  /**
    * <b>Auto generated</b> Redis API client wrapper.

    */

  implicit class RedisAPIScala(val asJava: io.vertx.redis.client.RedisAPI) extends AnyVal {


    /**
     * Like append from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def appendFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.append(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like asking from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def askingFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.asking(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like auth from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def authFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.auth(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bgrewriteaof from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bgrewriteaofFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.bgrewriteaof(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bgsave from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bgsaveFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.bgsave(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bitcount from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bitcountFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.bitcount(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bitfield from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bitfieldFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.bitfield(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bitop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bitopFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.bitop(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bitpos from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bitposFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.bitpos(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like blpop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def blpopFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.blpop(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like brpop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def brpopFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.brpop(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like brpoplpush from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def brpoplpushFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.brpoplpush(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bzpopmax from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bzpopmaxFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.bzpopmax(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bzpopmin from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bzpopminFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.bzpopmin(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like client from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def clientFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.client(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like cluster from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def clusterFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.cluster(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like command from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def commandFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.command(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like config from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def configFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.config(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like dbsize from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def dbsizeFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.dbsize(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like debug from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def debugFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.debug(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like decr from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def decrFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.decr(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like decrby from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def decrbyFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.decrby(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like del from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def delFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.del(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like discard from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def discardFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.discard(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like dump from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def dumpFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.dump(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like echo from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def echoFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.echo(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like eval from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def evalFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.eval(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like evalsha from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def evalshaFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.evalsha(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exec from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def execFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.exec(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like exists from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def existsFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.exists(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like expire from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def expireFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.expire(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like expireat from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def expireatFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.expireat(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like flushall from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def flushallFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.flushall(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like flushdb from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def flushdbFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.flushdb(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like geoadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def geoaddFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.geoadd(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like geodist from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def geodistFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.geodist(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like geohash from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def geohashFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.geohash(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like geopos from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def geoposFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.geopos(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like georadius from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def georadiusFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.georadius(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like georadiusRo from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def georadiusRoFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.georadiusRo(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like georadiusbymember from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def georadiusbymemberFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.georadiusbymember(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like georadiusbymemberRo from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def georadiusbymemberRoFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.georadiusbymemberRo(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like get from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.get(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getbit from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getbitFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.getbit(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getrangeFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.getrange(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getsetFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.getset(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hdel from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hdelFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hdel(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hexists from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hexistsFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hexists(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hget from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hgetFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hget(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hgetall from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hgetallFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hgetall(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hincrby from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hincrbyFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hincrby(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hincrbyfloat from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hincrbyfloatFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hincrbyfloat(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hkeys from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hkeysFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hkeys(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hlen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hlenFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hlen(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hmget from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hmgetFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hmget(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hmset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hmsetFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hmset(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like host from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hostFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.host(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hscan from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hscanFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hscan(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hsetFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hset(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hsetnx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hsetnxFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hsetnx(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hstrlen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hstrlenFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hstrlen(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like hvals from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def hvalsFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.hvals(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like incr from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def incrFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.incr(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like incrby from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def incrbyFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.incrby(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like incrbyfloat from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def incrbyfloatFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.incrbyfloat(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like info from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def infoFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.info(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like keys from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def keysFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.keys(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lastsave from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lastsaveFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lastsave(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like latency from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def latencyFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.latency(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lindex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lindexFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lindex(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like linsert from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def linsertFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String, arg3: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.linsert(arg0, arg1, arg2, arg3, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like llen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def llenFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.llen(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lolwut from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lolwutFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lolwut(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lpop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lpopFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lpop(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lpush from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lpushFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lpush(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lpushx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lpushxFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lpushx(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lrangeFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lrange(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lrem from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lremFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lrem(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like lset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def lsetFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.lset(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like ltrim from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def ltrimFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.ltrim(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like memory from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def memoryFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.memory(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like mget from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def mgetFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.mget(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like migrate from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def migrateFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.migrate(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like module from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def moduleFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.module(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like monitor from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def monitorFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.monitor(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like move from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def moveFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.move(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like mset from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def msetFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.mset(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like msetnx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def msetnxFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.msetnx(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like multi from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def multiFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.multi(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like object from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def objectFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.`object`(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like persist from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def persistFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.persist(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pexpire from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pexpireFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pexpire(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pexpireat from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pexpireatFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pexpireat(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pfadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pfaddFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pfadd(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pfcount from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pfcountFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pfcount(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pfdebug from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pfdebugFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pfdebug(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pfmerge from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pfmergeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pfmerge(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pfselftest from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pfselftestFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pfselftest(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like ping from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pingFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.ping(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like post from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def postFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.post(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like psetex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def psetexFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.psetex(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like psubscribe from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def psubscribeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.psubscribe(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like psync from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def psyncFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.psync(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pttl from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pttlFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pttl(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like publish from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def publishFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.publish(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pubsub from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pubsubFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.pubsub(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like punsubscribe from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def punsubscribeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.punsubscribe(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like randomkey from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def randomkeyFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.randomkey(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like readonly from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def readonlyFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.readonly(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like readwrite from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def readwriteFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.readwrite(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like rename from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def renameFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.rename(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like renamenx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def renamenxFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.renamenx(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like replconf from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replconfFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.replconf(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like replicaof from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replicaofFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.replicaof(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like restore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def restoreFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.restore(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like restoreAsking from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def restoreAskingFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.restoreAsking(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like role from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def roleFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.role(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like rpop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def rpopFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.rpop(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like rpoplpush from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def rpoplpushFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.rpoplpush(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like rpush from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def rpushFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.rpush(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like rpushx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def rpushxFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.rpushx(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def saddFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sadd(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like save from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def saveFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.save(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like scan from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def scanFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.scan(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like scard from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def scardFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.scard(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like script from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def scriptFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.script(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sdiff from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sdiffFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sdiff(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sdiffstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sdiffstoreFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sdiffstore(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like select from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def selectFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.select(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like set from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def setFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.set(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like setbit from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def setbitFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.setbit(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like setex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def setexFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.setex(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like setnx from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def setnxFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.setnx(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like setrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def setrangeFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.setrange(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like shutdown from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def shutdownFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.shutdown(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sinter from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sinterFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sinter(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sinterstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sinterstoreFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sinterstore(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sismember from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sismemberFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sismember(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like slaveof from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def slaveofFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.slaveof(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like slowlog from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def slowlogFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.slowlog(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like smembers from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def smembersFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.smembers(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like smove from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def smoveFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.smove(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sort from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sortFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sort(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like spop from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def spopFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.spop(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like srandmember from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def srandmemberFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.srandmember(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like srem from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sremFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.srem(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sscan from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sscanFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sscan(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like strlen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def strlenFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.strlen(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like subscribe from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def subscribeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.subscribe(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like substr from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def substrFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.substr(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sunion from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sunionFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sunion(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sunionstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sunionstoreFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sunionstore(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like swapdb from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def swapdbFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.swapdb(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like sync from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def syncFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.sync(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like time from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def timeFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.time(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like touch from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def touchFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.touch(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like ttl from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def ttlFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.ttl(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like type from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def typeFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.`type`(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unlink from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unlinkFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.unlink(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unsubscribe from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unsubscribeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.unsubscribe(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like unwatch from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unwatchFuture() : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.unwatch(new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like wait from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def waitFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.wait(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like watch from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def watchFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.watch(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xack from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xackFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xack(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xaddFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xadd(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xclaim from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xclaimFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xclaim(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xdel from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xdelFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xdel(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xgroup from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xgroupFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xgroup(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xinfo from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xinfoFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xinfo(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xlen from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xlenFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xlen(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xpending from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xpendingFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xpending(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xrangeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xrange(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xread from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xreadFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xread(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xreadgroup from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xreadgroupFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xreadgroup(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xrevrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xrevrangeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xrevrange(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xsetid from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xsetidFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xsetid(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like xtrim from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def xtrimFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.xtrim(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zadd from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zaddFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zadd(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zcard from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zcardFuture(arg0: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zcard(arg0, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zcount from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zcountFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zcount(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zincrby from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zincrbyFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zincrby(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zinterstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zinterstoreFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zinterstore(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zlexcount from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zlexcountFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zlexcount(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zpopmax from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zpopmaxFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zpopmax(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zpopmin from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zpopminFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zpopmin(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zrangeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrange(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrangebylex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zrangebylexFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrangebylex(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrangebyscore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zrangebyscoreFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrangebyscore(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrank from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zrankFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrank(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrem from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zremFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrem(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zremrangebylex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zremrangebylexFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zremrangebylex(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zremrangebyrank from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zremrangebyrankFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zremrangebyrank(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zremrangebyscore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zremrangebyscoreFuture(arg0: java.lang.String, arg1: java.lang.String, arg2: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zremrangebyscore(arg0, arg1, arg2, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrevrange from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zrevrangeFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrevrange(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrevrangebylex from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zrevrangebylexFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrevrangebylex(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrevrangebyscore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zrevrangebyscoreFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrevrangebyscore(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zrevrank from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zrevrankFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zrevrank(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zscan from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zscanFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zscan(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zscore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zscoreFuture(arg0: java.lang.String, arg1: java.lang.String) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zscore(arg0, arg1, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like zunionstore from [[io.vertx.redis.client.RedisAPI]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def zunionstoreFuture(args: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.zunionstore(args.asJava, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * A simple Redis client.

    */

  implicit class RedisConnectionScala(val asJava: io.vertx.redis.client.RedisConnection) extends AnyVal {

    /**
     * 
     */
  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

    /**
     * 
     */
  def handler(handler: scala.Option[io.vertx.redis.client.Response => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.redis.client.Response]]).getOrElse(null))
  }

    /**
     * 
     */
  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.redis.client.Response]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.redis.client.RedisConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(command: io.vertx.redis.client.Request) : scala.concurrent.Future[io.vertx.redis.client.Response] = {
      val promise = concurrent.Promise[io.vertx.redis.client.Response]/*io.vertx.redis.client.Response API*/()
      asJava.send(command, new Handler[AsyncResult[io.vertx.redis.client.Response]] { override def handle(event: AsyncResult[io.vertx.redis.client.Response]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like batch from [[io.vertx.redis.client.RedisConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def batchFuture(commands: scala.collection.mutable.Buffer[io.vertx.redis.client.Request]) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.redis.client.Response]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.redis.client.Response]]/*java.util.List[io.vertx.redis.client.Response] LIST*/()
      asJava.batch(commands.asJava, new Handler[AsyncResult[java.util.List[io.vertx.redis.client.Response]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.redis.client.Response]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }


  }



  type RedisOptions = io.vertx.redis.client.RedisOptions
  object RedisOptions {
    def apply() = new RedisOptions()
    def apply(json: JsonObject) = new RedisOptions(json)
  }



  object Request {
  def cmd(command: io.vertx.redis.client.Command) = {
      io.vertx.redis.client.Request.cmd(command)
  }
  }




}
