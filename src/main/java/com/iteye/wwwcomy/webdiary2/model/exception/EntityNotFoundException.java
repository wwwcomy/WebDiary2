package com.iteye.wwwcomy.webdiary2.model.exception;

/**
 * Indicates that the entity is not found
 *
 */
public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3350262420867359131L;

	public EntityNotFoundException() {
	}

	public EntityNotFoundException(String s) {
		super(s);
	}

	public EntityNotFoundException(String s, Throwable e) {
		super(s, e);
	}
}
