package org.attentiveness.news.internal.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation PerActivity
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}