package com.walmart.springboot.utilities;

import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CacheSetup implements JCacheManagerCustomizer {
	
	@Override
	public void customize(javax.cache.CacheManager cacheManager) {
		cacheManager.createCache("walmart", new MutableConfiguration<>()
                .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(java.util.concurrent.TimeUnit.SECONDS, 30 )))
                .setStoreByValue(false)
                .setStatisticsEnabled(true));
	}
}