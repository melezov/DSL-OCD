module CalculatedPropertyInAggregateSetup
{
  aggregate OneArrayOfOneStringsWithMaxLengthOf9_4 {
    Array<String(9)> oneArrayOfOneStringsWithMaxLengthOf9;

    calculated Array<String(9)> calculatedOneArrayOfOneStringsWithMaxLengthOf9 from 'it => it.oneArrayOfOneStringsWithMaxLengthOf9';

    calculated Array<String(9)> persistedOneArrayOfOneStringsWithMaxLengthOf9 from 'it => it.oneArrayOfOneStringsWithMaxLengthOf9' { persisted; }
  }
}