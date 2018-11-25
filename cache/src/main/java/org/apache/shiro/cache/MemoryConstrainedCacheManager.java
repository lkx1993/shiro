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

import org.apache.shiro.util.SoftHashMap;

/**
 * Simple memory-only based {@link CacheManager CacheManager} implementation usable in production
 * environments.  It will not cause memory leaks as it produces {@link Cache Cache}s backed by
 * {@link SoftHashMap SoftHashMap}s which auto-size themselves based on the runtime environment's memory
 * limitations and garbage collection behavior.
 * 简单的基于内存的{@link CacheManager CacheManager}实现，在生产环境中可用.
 * 它不会导致内存泄漏，因为它产生的{@link SoftHashMap SoftHashMap}根据运行时环境的
 * 内存自动调整大小限制和垃圾收集行为。
 * <p/>
 * While the {@code Cache} instances created are thread-safe, they do not offer any enterprise-level features such as
 * cache coherency, optimistic locking, failover or other similar features.  For more enterprise features, consider
 * using a different {@code CacheManager} implementation backed by an enterprise-grade caching product (Hazelcast,
 * EhCache, TerraCotta, Coherence, GigaSpaces, etc, etc).
 *虽然创建的{@code Cache}实例是线程安全的，但是它们不提供任何企业级特性，例如
 *缓存一致性、乐观锁定、故障转移或其他类似特性。要了解更多企业特性，请考虑使用不同的{@code CacheManager}实现，
 * 支持企业级缓存产品(Hazelcast，EhCache, TerraCotta, Coherence, GigaSpaces等等)
 * @since 1.0
 */
public class MemoryConstrainedCacheManager extends AbstractCacheManager {

    /**
     * Returns a new {@link MapCache MapCache} instance backed by a {@link SoftHashMap}.
     *
     * @param name the name of the cache
     * @return a new {@link MapCache MapCache} instance backed by a {@link SoftHashMap}.
     */
    @Override
    protected Cache createCache(String name) {
        return new MapCache<Object, Object>(name, new SoftHashMap<Object, Object>());
    }
}
