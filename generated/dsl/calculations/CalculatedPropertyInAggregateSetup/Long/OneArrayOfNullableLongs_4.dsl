module CalculatedPropertyInAggregateSetup
{
  aggregate OneArrayOfNullableLongs_4 {
    Array<Long?> oneArrayOfNullableLongs;

    calculated Array<Long?> calculatedOneArrayOfNullableLongs from 'it => it.oneArrayOfNullableLongs';

    calculated Array<Long?> persistedOneArrayOfNullableLongs from 'it => it.oneArrayOfNullableLongs' { persisted; }
  }
}