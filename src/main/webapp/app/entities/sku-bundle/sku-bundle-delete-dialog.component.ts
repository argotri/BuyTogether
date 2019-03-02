import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ISkuBundle } from 'app/shared/model/sku-bundle.model';
import { SkuBundleService } from './sku-bundle.service';

@Component({
    selector: 'jhi-sku-bundle-delete-dialog',
    templateUrl: './sku-bundle-delete-dialog.component.html'
})
export class SkuBundleDeleteDialogComponent {
    skuBundle: ISkuBundle;

    constructor(
        protected skuBundleService: SkuBundleService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.skuBundleService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'skuBundleListModification',
                content: 'Deleted an skuBundle'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sku-bundle-delete-popup',
    template: ''
})
export class SkuBundleDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ skuBundle }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(SkuBundleDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.skuBundle = skuBundle;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/sku-bundle', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/sku-bundle', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
