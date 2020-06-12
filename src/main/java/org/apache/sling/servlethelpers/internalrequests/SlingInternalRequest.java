/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.servlethelpers.internalrequests;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.engine.SlingRequestProcessor;

/** Common interface between the various types of 
 *  internal requests
 */
class SlingInternalRequest extends InternalRequest {
    protected final SlingRequestProcessor processor;

    SlingInternalRequest(ResourceResolver resolver, SlingRequestProcessor p, String path) {
        super(resolver, path);
        processor = p;
    }

    @Override
    protected void delegateExecute(SlingHttpServletRequest request, SlingHttpServletResponse response, ResourceResolver resourceResolver)
    throws ServletException, IOException {
        log.debug("Executing request using the SlingRequestProcessor");
        processor.processRequest(request, response, resourceResolver);
    }
}
