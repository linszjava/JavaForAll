## transaction  redis 事务
####----------start -----------------------------------------------------
127.0.0.1:6379[9]> multi
OK
127.0.0.1:6379[9](TX)> set l1 v1
QUEUED
127.0.0.1:6379[9](TX)> set l2 v2
QUEUED
127.0.0.1:6379[9](TX)> set l3
(error) ERR wrong number of arguments for 'set' command     ## ① 假如执行了 multi  然后中间出行了运行错误，然后 exec 则全部执行
127.0.0.1:6379[9](TX)> exec
(error) EXECABORT Transaction discarded because of previous errors.
127.0.0.1:6379[9]> keys *
(empty array)
127.0.0.1:6379[9]> multi
OK
127.0.0.1:6379[9](TX)> set k1 v1
QUEUED
127.0.0.1:6379[9](TX)> set k2 v2
QUEUED
127.0.0.1:6379[9](TX)> discard                              ## ② 假如执行了 multi  然后中间直接discard  则全部不执行
OK
127.0.0.1:6379[9]> get k1
(nil)
127.0.0.1:6379[9]> keys *
(empty array)
127.0.0.1:6379[9]> multi
OK
127.0.0.1:6379[9](TX)> set j1 v1
QUEUED
127.0.0.1:6379[9](TX)> set j2 v2
QUEUED
127.0.0.1:6379[9](TX)> incr j2
QUEUED
127.0.0.1:6379[9](TX)> exec
1) OK
2) OK
3) (error) ERR value is not an integer or out of range   ## ③ 假如执行了 multi  然后exec  但是中间出行了运行错误，则前 后 成功的，提交事务
127.0.0.1:6379[9]>


####----------end -----------------------------------------------------


