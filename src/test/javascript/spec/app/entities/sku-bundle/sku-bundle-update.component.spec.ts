/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { BuyTogetherTestModule } from '../../../test.module';
import { SkuBundleUpdateComponent } from 'app/entities/sku-bundle/sku-bundle-update.component';
import { SkuBundleService } from 'app/entities/sku-bundle/sku-bundle.service';
import { SkuBundle } from 'app/shared/model/sku-bundle.model';

describe('Component Tests', () => {
    describe('SkuBundle Management Update Component', () => {
        let comp: SkuBundleUpdateComponent;
        let fixture: ComponentFixture<SkuBundleUpdateComponent>;
        let service: SkuBundleService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BuyTogetherTestModule],
                declarations: [SkuBundleUpdateComponent]
            })
                .overrideTemplate(SkuBundleUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(SkuBundleUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SkuBundleService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new SkuBundle(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.skuBundle = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new SkuBundle();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.skuBundle = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
