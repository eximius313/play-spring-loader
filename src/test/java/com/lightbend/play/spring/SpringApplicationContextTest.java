/*
 * Copyright 2017 Lightbend
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

package com.lightbend.play.spring;

import org.junit.Test;
import play.Application;
import play.DefaultApplication;
import play.inject.DelegateInjector;
import play.test.WithApplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SpringApplicationContextTest extends WithApplication {
  
  @Override
  protected Application provideApplication() {
    final SpringApplicationBuilder builder = new SpringApplicationBuilder();
    final play.api.Application app = builder.build();
    return new DefaultApplication(app, new DelegateInjector(app.injector()));
  }
	
  @Test
  public void shouldStartApplicationContext() {
    final AnnotationConfigApplicationContext context = instanceOf(AnnotationConfigApplicationContext.class);
    assertTrue(context.isRunning());
  }

  @Test
  public void shouldStopApplicationContext() {
    final AnnotationConfigApplicationContext context = instanceOf(AnnotationConfigApplicationContext.class);
    stopPlay();
    assertFalse(context.isRunning());
  }
}
