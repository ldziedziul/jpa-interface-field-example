package pl.dziedziul.jpainterfacefieldexample.library;

import javax.persistence.AttributeConverter;

public abstract class AbstractEntityTypeConverter implements AttributeConverter<Type, String> {
	@Override
	public String convertToDatabaseColumn(Type attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.name();
	}

	@Override
	public Type convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return parseEnum(dbData);
	}

	protected abstract Type parseEnum(String dbData);
}
