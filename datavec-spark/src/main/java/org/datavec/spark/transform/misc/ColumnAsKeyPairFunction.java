package org.datavec.spark.transform.misc;

import lombok.AllArgsConstructor;
import org.apache.spark.api.java.function.PairFunction;
import org.datavec.api.writable.Writable;
import scala.Tuple2;

import java.util.List;

/**
 * Very simple function to extract out one writable (by index) and use it as a key in the resulting PairRDD
 * For example, myWritable.mapToPair(new ColumnsAsKeyPairFunction(myKeyColumnIdx))
 *
 * @author Alex Black
 */
@AllArgsConstructor
public class ColumnAsKeyPairFunction implements PairFunction<List<Writable>, Writable, List<Writable>> {
    private final int columnIdx;

    @Override
    public Tuple2<Writable, List<Writable>> call(List<Writable> writables) throws Exception {
        return new Tuple2<>(writables.get(columnIdx), writables);
    }
}