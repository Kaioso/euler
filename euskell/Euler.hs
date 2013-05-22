-- PROJECT EULER

import Definitions
import Control.Applicative ((<*>))
import Data.List

--E1 Multiples of 3 and 5
one :: Integer
one = sum (filter multis [0..999])
    where
        multis x
            | x `mod` 3 == 0 || x `mod` 5 == 0 = True
            | otherwise = False

--E2 Even Fibonacci numbers
two :: Integer -> Integer
two limit = sum $ filter even (takeWhile (\x -> x < limit) fibs)

--E3 Largest prime factor
three =
    let
        --magic = 13195
        magic = 600851475143
        maxdiv = truncate . sqrt . fromIntegral $ magic
        throw x
            | magic `mod` x == 0 = if isPrime x then x else throw (x - 1)
            | otherwise = throw (x - 1)
    in throw maxdiv

--E4 Largest palindrome from the product of three digit numbers
pal_digit = 3
pal_top = (10 ^ pal_digit) - 1
pal_bottom = 10 ^ (pal_digit - 1)

four = pal
    where
        (begin, pal:rest) = break (\x -> x `elem` palindromes) (sortBy (flip compare) (fmap (*) range <*> range))
        range = [pal_top,(pal_top - 1)..pal_bottom]
        palindromes = filter isPalindrome [pal_top ^ 2,((pal_top ^ 2) - 1)..pal_bottom ^ 2]
        isPalindrome x = show x == (reverse . show) x

-- E5 Least common multiple of [1..20]

--five :: Integer
--five = (product evens / divisor) * product odds
--odds :: (Num a) => [a]
--odds = map fromIntegral $ filter odd filist
--evens :: (Num a) => [a]
--evens = map fromIntegral $ filter even filist
--divisor :: (Num a) => a
--divisor = fromIntegral $ last (scanl gcd 0 (reverse . tail $ evens))

five = head $ dropWhile (not . divisible) (map (\x -> 20*(19*x)) [1..])
    where
        divisible nu = foldl (\acc x -> acc && nu `mod` x == 0) True [20,19..1]
five' = foldl lcm 1 [1..20]