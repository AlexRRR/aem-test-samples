/*
 * Copyright 2018 Adobe Systems Incorporated
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adobe.cq.testing.it.smoke;

import com.adobe.cq.testing.client.CQClient;
import com.adobe.cq.testing.junit.rules.CQAuthorPublishClassRule;
import com.adobe.cq.testing.junit.rules.CQRule;
import com.adobe.cq.testing.junit.rules.Page;
import org.apache.sling.testing.clients.ClientException;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.MINUTES;

public class GetPageIT {

    private static final long TIMEOUT = MINUTES.toMillis(2);

    @ClassRule
    public static CQAuthorPublishClassRule cqBaseClassRule = new CQAuthorPublishClassRule();

    @Rule
    public CQRule cqBaseRule = new CQRule(cqBaseClassRule.authorRule, cqBaseClassRule.publishRule);

    @Rule
    public Page root = new Page(cqBaseClassRule.authorRule);

    static CQClient adminAuthor;
    static CQClient adminPublish;
    static CQClient anonymousPublish;

    @BeforeClass
    public static void beforeClass() throws ClientException {
        adminAuthor = cqBaseClassRule.authorRule.getAdminClient(CQClient.class);
        adminPublish = cqBaseClassRule.publishRule.getAdminClient(CQClient.class);
        anonymousPublish = cqBaseClassRule.publishRule.getClient(CQClient.class, null, null);
    }

    /**
     * Verifies that the homepage exists on author
     */
    @Test
    public void testHomePageAuthor() throws ClientException {
        // verify that page is present on author
        adminAuthor.doGet("/", 200);
    }

    /**
     * Verifies that the homepage exists on publish
     */
    @Test
    public void testHomePagePublish() throws ClientException {
        // verify that page is present on author
        adminPublish.doGet("/", 200);
    }

    /**
     * Verifies that the homepage exists on publish for anonymous
     */
    @Test
    public void testHomePagePublishAnonymous() throws ClientException {
        // verify that page is present on author
        anonymousPublish.doGet("/", 200);
    }
}
