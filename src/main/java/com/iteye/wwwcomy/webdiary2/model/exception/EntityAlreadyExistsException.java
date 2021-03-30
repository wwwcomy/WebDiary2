package com.iteye.wwwcomy.webdiary2.model.exception;

/**
 * Indicates that the entity already exists
 *
 */
public class EntityAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = -3350262420867359131L;

	public EntityAlreadyExistsException() {
	}

	public EntityAlreadyExistsException(String s) {
		super(s);
	}

	public EntityAlreadyExistsException(String s, Throwable e) {
		super(s, e);
	}
}
