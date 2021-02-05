/**
  * Copyright Whitebox Software Ltd. 2014
  * All Rights Reserved.

  * Created by chris on 15/02/2016.

  */
package io.venuu.vuu.core.module

import java.nio.file.Path

import io.venuu.toolbox.lifecycle.LifecycleContainer
import io.venuu.toolbox.time.Clock
import io.venuu.vuu.api.TableDef
import io.venuu.vuu.core.ViewServer
import io.venuu.vuu.core.table.DataTable
import io.venuu.vuu.net.rpc.RpcHandler
import io.venuu.vuu.provider.Provider

trait RealizedViewServerModule extends ViewServerModule{
  def rpcHandler: RpcHandler
}

case class StaticServedResource(url: String, directory: Path, canBrowse: Boolean)

trait ViewServerModule {
  def name: String
  def tableDefs: List[TableDef]
  def serializationMixin: Object
  def rpcHandlerUnrealized: ViewServer => RpcHandler
  def getProviderForTable(table: DataTable, viewserver: ViewServer)(implicit time: Clock, lifecycleContainer: LifecycleContainer): Provider
  def staticFileResources():  List[StaticServedResource]
}