package org.reflections;

import org.reflections.scanners.Scanner;

import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Configuration is used to create a configured instance of {@link Reflections}
 * <p>it is preferred to use {@link org.reflections.util.ConfigurationBuilder}
 */
public interface Configuration {
    /** the scanner instances used for indexing metadata. defaults to {@code SubTypes} and {@code TypesAnnotated}. */
    Set<Scanner> getScanners(); // scanner用来indexing metadata，默认scan SubTypes和TypesAnnotated

    /** the urls to be scanned. required. */
    Set<URL> getUrls(); // 需要去scan的路径

    /** the fully qualified name filter used to filter types to be scanned. defaults to accept all inputs (if null). */
    Predicate<String> getInputsFilter(); // 是否过滤某些type

    /** scan urls in parallel. defaults to true. */
    boolean isParallel();

    /** optional class loaders used for resolving types. */
    ClassLoader[] getClassLoaders(); // 使用classloader解析type

    /** if true (default), expand super types after scanning, for super types that were not scanned.
     * <p>see {@link Reflections#expandSuperTypes(Map, Map)}*/
    boolean shouldExpandSuperTypes(); // scan后，是否继续scan没有scan的supertype
}
