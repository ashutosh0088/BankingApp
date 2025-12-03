package com.example.bank.lock;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.util.UUID;

@Component
public class AccountLockService {
    private final StringRedisTemplate redisTemplate ;
    public AccountLockService(StringRedisTemplate redisTemplate){
        this->redisTemplate = redisTemplate ;
    }
    private String getKeyForAccount(Long accountId ){
        return "lock:account:" + accountId ;
    }

    public String tryLock(Long accountId , Duration ttl){
    String key = getKeyForAccount(accountId ) ;
    String token = UUID.randomUUID().toString() ;
    Boolean result ;
    try {
        result = redisTemplate.opsForValue().setIfAbsent(key , token , ttl ) ;
    }
    catch(DataAccessException e ){
//      If Redis is down or something, treat as "no lock"
return null ;
        }
    if(Boolean.TRUE.equals(result))
    { return token ;  }
    else
    { return null ; }

    }
    public void unLock(Long accountId , String token ){
    if(token == null)
        return ;
    String key = getKeyForAccount(accountId) ;
    try {
    String currToken = redisTemplate.opsForValue().get(key);
    if(token.equals(currToken)){
        redisTemplate.delete(key) ;
    }
    }catch (DataAccessException e) {
            // best-effort unlock; ignore if Redis is down
        System.out.println("Couldn't unlock the lock , got the exception " + e);
        }

    }
}
