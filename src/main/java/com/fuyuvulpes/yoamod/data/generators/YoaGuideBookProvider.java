package com.fuyuvulpes.yoamod.data.generators;

import com.klikli_dev.modonomicon.api.datagen.BookProvider;
import com.klikli_dev.modonomicon.api.datagen.ModonomiconLanguageProvider;
import com.klikli_dev.modonomicon.api.datagen.book.BookModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class YoaGuideBookProvider extends BookProvider {
    public YoaGuideBookProvider(PackOutput packOutput, String modid, ModonomiconLanguageProvider defaultLang, ModonomiconLanguageProvider... translations) {
        super("yoa_mod", packOutput, modid, defaultLang, translations);
    }

    @Override
    protected void registerDefaultMacros() {

    }

    @Override
    protected BookModel generateBook() {
        var featuresCategory = new FeatureCategoryProvider(this, "features").generate();

        var yoaBook = BookModel.create(
                        this.modLoc(this.context().bookId()), //the id of the book. modLoc() prepends the mod id.
                        this.context().bookName() //the name of the book. The lang helper gives us the correct translation key.
                )
                .withTooltip(this.context().bookTooltip()) //the hover tooltip for the book. Again we get a translation key.
                .withGenerateBookItem(true) //auto-generate a book item for us.
                .withModel(new ResourceLocation("yoamod:guide_book")) //use the default red modonomicon icon for the book
                .withCreativeTab(new ResourceLocation("modonomicon", "modonomicon")) //and put it in the modonomicon tab
                .withCategories(
                        featuresCategory
                );

        this.lang().add(this.context().bookName(), "Demo Book"); //and now we add the actual textual book name
        this.lang().add(this.context().bookTooltip(), "A book to showcase & test Modonomicon features."); //and the tooltip text
        return yoaBook;
    }
}
