
package com.nicholaspiazza.marveltimeline;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated("org.parceler.ParcelAnnotationProcessor")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class Movie$$Parcelable
    implements Parcelable, ParcelWrapper<com.nicholaspiazza.marveltimeline.Movie>
{

    private com.nicholaspiazza.marveltimeline.Movie movie$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Movie$$Parcelable>CREATOR = new Creator<Movie$$Parcelable>() {


        @Override
        public Movie$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Movie$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Movie$$Parcelable[] newArray(int size) {
            return new Movie$$Parcelable[size] ;
        }

    }
    ;

    public Movie$$Parcelable(com.nicholaspiazza.marveltimeline.Movie movie$$2) {
        movie$$0 = movie$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(movie$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.nicholaspiazza.marveltimeline.Movie movie$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(movie$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(movie$$1));
            parcel$$1 .writeString(movie$$1 .overView);
            parcel$$1 .writeDouble(movie$$1 .movieRating);
            parcel$$1 .writeString(movie$$1 .releaseDate);
            parcel$$1 .writeInt(movie$$1 .movieId);
            parcel$$1 .writeString(movie$$1 .mediaType);
            parcel$$1 .writeString(movie$$1 .title);
            parcel$$1 .writeString(movie$$1 .posterPath);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.nicholaspiazza.marveltimeline.Movie getParcel() {
        return movie$$0;
    }

    public static com.nicholaspiazza.marveltimeline.Movie read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.nicholaspiazza.marveltimeline.Movie movie$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            movie$$4 = new com.nicholaspiazza.marveltimeline.Movie();
            identityMap$$1 .put(reservation$$0, movie$$4);
            movie$$4 .overView = parcel$$3 .readString();
            movie$$4 .movieRating = parcel$$3 .readDouble();
            movie$$4 .releaseDate = parcel$$3 .readString();
            movie$$4 .movieId = parcel$$3 .readInt();
            movie$$4 .mediaType = parcel$$3 .readString();
            movie$$4 .title = parcel$$3 .readString();
            movie$$4 .posterPath = parcel$$3 .readString();
            com.nicholaspiazza.marveltimeline.Movie movie$$3 = movie$$4;
            identityMap$$1 .put(identity$$1, movie$$3);
            return movie$$3;
        }
    }

}
