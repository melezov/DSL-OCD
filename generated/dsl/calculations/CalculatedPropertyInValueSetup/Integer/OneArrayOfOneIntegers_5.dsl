module CalculatedPropertyInValueSetup
{
  value OneArrayOfOneIntegers_5 {
    Array<Integer> oneArrayOfOneIntegers;

    calculated Array<Integer> calculatedOneArrayOfOneIntegers from 'it => it.oneArrayOfOneIntegers';

    calculated Array<Integer> persistedOneArrayOfOneIntegers from 'it => it.oneArrayOfOneIntegers' { persisted; }
  }
}