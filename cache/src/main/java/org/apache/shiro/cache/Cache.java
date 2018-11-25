/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.shiro.cache;

import java.util.Collection;
import java.util.Set;

/**
 * A Cache efficiently stores temporary objects primarily to improve an application's performance.
 *缓存有效地存储临时对象主要是为了提高应用程序的性能。
 *
 * <p>Shiro doesn't implement a full Cache mechanism itself, since that is outside the core competency of a
 * Security framework.  Instead, this interface provides an abstraction (wrapper) API on top of an underlying
 * cache framework's cache instance (e.g. JCache, Ehcache, JCS, OSCache, JBossCache, TerraCotta, Coherence,
 * GigaSpaces, etc, etc), allowing a Shiro user to configure any cache mechanism they choose.
 *Shiro本身没有实现完整的缓存机制，因为这超出了安全框架。
 * 相反，这个接口提供了底层之上的抽象（包装）API
 *缓存框架的缓存实例（例如，JCache、Ehcache、JCS、OSCache、JBossCache、TerraCotta、Coherence，
 *千兆空间等），允许Shiro用户配置他们选择的任何缓存机制。
 *
 * @since 0.2
 */
public interface Cache<K, V> {

    /**
     * Returns the Cached value stored under the specified {@code key} or
     * {@code null} if there is no Cache entry for that {@code key}.
     *
     * @param key the key that the value was previous added with
     * @return the cached object or {@code null} if there is no entry for the specified {@code key}
     * @throws CacheException if there is a problem accessing the underlying cache system
     */
    public V get(K key) throws CacheException;

    /**
     * Adds a Cache entry.
     *
     * @param key   the key used to identify the object being stored.
     * @param value the value to be stored in the cache.
     * @return the previous value associated with the given {@code key} or {@code null} if there was previous value
     * @throws CacheException if there is a problem accessing the underlying cache system
     */
    public V put(K key, V value) throws CacheException;

    /**
     * Remove the cache entry corresponding to the specified key.
     *
     * @param key the key of the entry to be removed.
     * @return the previous value associated with the given {@code key} or {@code null} if there was previous value
     * @throws CacheException if there is a problem accessing the underlying cache system
     */
    public V remove(K key) throws CacheException;

    /**
     * Clear all entries from the cache.
     *
     * @throws CacheException if there is a problem accessing the underlying cache system
     */
    public void clear() throws CacheException;

    /**
     * Returns the number of entries in the cache.
     *
     * @return the number of entries in the cache.
     */
    public int size();

    /**
     * Returns a view of all the keys for entries contained in this cache.
     *
     * @return a view of all the keys for entries contained in this cache.
     */
    public Set<K> keys();

    /**
     * Returns a view of all of the values contained in this cache.
     *
     * @return a view of all of the values contained in this cache.
     */
    public Collection<V> values();
}
