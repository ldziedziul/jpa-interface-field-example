package pl.dziedziul.jpainterfacefieldexample.app;

import javax.persistence.Converter;

import pl.dziedziul.jpainterfacefieldexample.library.AbstractEntityTypeConverter;

@Converter(autoApply = true)
public class SpecificEntityTypeConverter extends AbstractEntityTypeConverter {

	@Override
	protected SpecificEntityType parseEnum(String dbData) {
		return SpecificEntityType.valueOf(dbData);
	}
}
