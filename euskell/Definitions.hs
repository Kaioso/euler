module Definitions where

-- Exercise 2
fibs = 1 : 1 : zipWith (+) fibs (tail fibs)

-- Ex 3
isPrime :: Integer -> Bool
isPrime x = if head (dropWhile (\y -> x `mod` y /= 0) [2..x]) /= x then False else True

primes = filter isPrime [2..]