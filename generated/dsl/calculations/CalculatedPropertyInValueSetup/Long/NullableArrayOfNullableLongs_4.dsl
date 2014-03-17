module CalculatedPropertyInValueSetup
{
  value NullableArrayOfNullableLongs_4 {
    Array<Long?>? nullableArrayOfNullableLongs;

    calculated Array<Long?>? calculatedNullableArrayOfNullableLongs from 'it => it.nullableArrayOfNullableLongs';

    calculated Array<Long?>? persistedNullableArrayOfNullableLongs from 'it => it.nullableArrayOfNullableLongs' { persisted; }
  }
}