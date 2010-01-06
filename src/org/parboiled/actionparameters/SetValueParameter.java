/*
 * Copyright (C) 2009 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.parboiled.actionparameters;

import org.jetbrains.annotations.NotNull;
import org.parboiled.ActionResult;
import org.parboiled.MatcherContext;

/**
 * A special ActionParameter that sets the value passed in as argument on the node to be created for the rule
 * corresponding to the current Context scope.
 */
public class SetValueParameter implements ActionParameter {
    private final Object value;

    public SetValueParameter(Object value) {
        this.value = value;
    }

    @SuppressWarnings({"unchecked"})
    public Object resolve(@NotNull MatcherContext<?> context) {
        ((MatcherContext)context).setNodeValue(ActionParameterUtils.resolve(value, context, null));
        return ActionResult.CONTINUE;
    }

    @Override
    public String toString() {
        return "SET(" + value + ')';
    }

}