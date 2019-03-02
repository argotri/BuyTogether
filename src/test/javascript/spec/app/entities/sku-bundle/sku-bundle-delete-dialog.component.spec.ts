/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { BuyTogetherTestModule } from '../../../test.module';
import { SkuBundleDeleteDialogComponent } from 'app/entities/sku-bundle/sku-bundle-delete-dialog.component';
import { SkuBundleService } from 'app/entities/sku-bundle/sku-bundle.service';

describe('Component Tests', () => {
    describe('SkuBundle Management Delete Component', () => {
        let comp: SkuBundleDeleteDialogComponent;
        let fixture: ComponentFixture<SkuBundleDeleteDialogComponent>;
        let service: SkuBundleService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BuyTogetherTestModule],
                declarations: [SkuBundleDeleteDialogComponent]
            })
                .overrideTemplate(SkuBundleDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SkuBundleDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SkuBundleService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
