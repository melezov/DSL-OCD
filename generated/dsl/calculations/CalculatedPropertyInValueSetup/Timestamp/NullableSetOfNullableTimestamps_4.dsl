module CalculatedPropertyInValueSetup
{
  value NullableSetOfNullableTimestamps_4 {
    Set<Timestamp?>? nullableSetOfNullableTimestamps;

    calculated Set<Timestamp?>? calculatedNullableSetOfNullableTimestamps from 'it => it.nullableSetOfNullableTimestamps';

    calculated Set<Timestamp?>? persistedNullableSetOfNullableTimestamps from 'it => it.nullableSetOfNullableTimestamps' { persisted; }
  }
}