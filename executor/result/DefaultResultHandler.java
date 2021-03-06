/*
 *    Copyright 2009-2012 The MyBatis Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.executor.result;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

/**
 * TODO 查询结果包装
 * 
 * @author seven
 *
 */
public class DefaultResultHandler implements ResultHandler {

	private final List<Object> list;

	public DefaultResultHandler() {
		list = new ArrayList<Object>();
	}

	/**
	 * 默认执行objectFactory.create(List.class)
	 * 此list为res叠加结果上下文
	 * @param objectFactory
	 */
	@SuppressWarnings("unchecked")
	public DefaultResultHandler(ObjectFactory objectFactory) {
		list = objectFactory.create(List.class);
	}

	public void handleResult(ResultContext context) {
		list.add(context.getResultObject());
	}

	public List<Object> getResultList() {
		return list;
	}

}
