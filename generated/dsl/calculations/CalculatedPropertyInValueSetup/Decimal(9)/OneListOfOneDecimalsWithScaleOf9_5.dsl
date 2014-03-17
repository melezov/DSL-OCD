module CalculatedPropertyInValueSetup
{
  value OneListOfOneDecimalsWithScaleOf9_5 {
    List<Decimal(9)> oneListOfOneDecimalsWithScaleOf9;

    calculated List<Decimal(9)> calculatedOneListOfOneDecimalsWithScaleOf9 from 'it => it.oneListOfOneDecimalsWithScaleOf9';

    calculated List<Decimal(9)> persistedOneListOfOneDecimalsWithScaleOf9 from 'it => it.oneListOfOneDecimalsWithScaleOf9' { persisted; }
  }
}