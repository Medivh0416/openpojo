/*
 * Copyright (c) 2010-2017 Osman Shoukry
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.openpojo.reflection.filters;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;

/**
 * This class will filter out Clover classes.
 * The logic for filtering is simple, since all clover generated classes have "$__CLR" in their name.
 *
 * @author oshoukry
 */
public class FilterCloverClasses implements PojoClassFilter {
  private static final String DEFAULT_CLOVER_TAG = "$__CLR";

  public boolean include(final PojoClass pojoClass) {
    return !pojoClass.getName().contains(DEFAULT_CLOVER_TAG);
  }

  @Override
  public boolean equals(Object o) {
    return this == o || !(o == null || getClass() != o.getClass());
  }

  @Override
  public int hashCode() {
    return this.getClass().hashCode();
  }

  public static FilterCloverClasses getInstance() {
    return Instance.INSTANCE;
  }

  private static class Instance {
    private static final FilterCloverClasses INSTANCE = new FilterCloverClasses();
  }
}
