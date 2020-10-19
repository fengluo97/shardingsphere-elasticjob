/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.elasticjob.lite.spring.namespace.error.parser;

import org.apache.shardingsphere.elasticjob.error.handler.wechat.WechatConfiguration;
import org.apache.shardingsphere.elasticjob.lite.spring.namespace.error.tag.WechatErrorHandlerBeanDefinitionTag;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Wechat error handler bean definition parser.
 */
public final class WechatErrorHandlerBeanDefinitionParser extends AbstractBeanDefinitionParser {
    
    @Override
    protected AbstractBeanDefinition parseInternal(final Element element, final ParserContext parserContext) {
        BeanDefinitionBuilder factory = BeanDefinitionBuilder.rootBeanDefinition(WechatConfiguration.class);
        factory.addConstructorArgValue(element.getAttribute(WechatErrorHandlerBeanDefinitionTag.WEBHOOK));
        factory.addConstructorArgValue(element.getAttribute(WechatErrorHandlerBeanDefinitionTag.CONNECT_TIMEOUT_MILLISECOND));
        factory.addConstructorArgValue(element.getAttribute(WechatErrorHandlerBeanDefinitionTag.READ_TIMEOUT_MILLISECOND));
        return factory.getBeanDefinition();
    }
}
