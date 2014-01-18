module CalculatedPropertyInAggregateSetup
{
  aggregate OneListOfNullableLongs_4 {
    List<Long?> oneListOfNullableLongs;

    calculated List<Long?> calculatedOneListOfNullableLongs from 'it => it.oneListOfNullableLongs';

    calculated List<Long?> persistedOneListOfNullableLongs from 'it => it.oneListOfNullableLongs' { persisted; }
  }
}
