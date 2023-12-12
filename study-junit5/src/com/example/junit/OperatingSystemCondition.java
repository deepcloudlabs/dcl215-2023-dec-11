package com.example.junit;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

public class OperatingSystemCondition implements ExecutionCondition{

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext ec) {
		var element = ec.getElement();
		var conditions = AnnotationUtils.findRepeatableAnnotations(element, ConditionalTestOnOperatingSystem.class);
		var osName = System.getProperty("os.name");
		System.out.println(osName);
		for (var condition : conditions) {
			var osType = condition.value();
			System.out.println(osType.name());
			if (osType.getOsName().equals(osName))
				return ConditionEvaluationResult.enabled("OS TYPE is %s".formatted(osType.getOsName()));
		}
		return ConditionEvaluationResult.disabled("OS is not supported for this test.");
	}

}
